const API_BASE = "";
const learnerName = localStorage.getItem("learnerName") || "Vivek";

let progressData = {
    completedTopicIds: []
};

document.addEventListener("DOMContentLoaded", async () => {
    await loadProgress();
    await loadRoadmap();
    setupTopicForm();
});

async function loadRoadmap() {
    const container = document.getElementById("phaseContainer");

    try {
        const response = await fetch(`${API_BASE}/api/roadmap/phases`);
        const phases = await response.json();

        container.innerHTML = "";

        phases.forEach(phase => {
            const phaseCard = document.createElement("div");
            phaseCard.className = "phase-card";

            const topicsHtml = phase.topics.map(topic => {
                const completed = progressData.completedTopicIds.includes(topic.id);

                return `
                    <div class="topic-item ${completed ? "completed" : ""}">
                        <button onclick="toggleTopic(${topic.id})">${completed ? "✓" : ""}</button>
                        <div>
                            <div class="topic-title">${topic.topicOrder}. ${topic.name}</div>
                            <div class="topic-desc">${topic.description || ""}</div>
                            ${topic.projectBased ? '<span class="project-label">Project Practice</span>' : ""}
                        </div>
                    </div>
                `;
            }).join("");

            phaseCard.innerHTML = `
                <div class="phase-header">
                    <div>
                        <h3>Phase ${phase.phaseOrder}: ${phase.title}</h3>
                        <div class="meta">
                            <span class="tag">ID: ${phase.id}</span>
                            <span class="tag">${phase.level || "Level"}</span>
                            <span class="tag">${phase.duration || "Duration"}</span>
                        </div>
                    </div>
                </div>
                <p><strong>Goal:</strong> ${phase.goal || ""}</p>
                <p>${phase.description || ""}</p>
                <div class="topic-list">${topicsHtml}</div>
            `;

            container.appendChild(phaseCard);
        });
    } catch (error) {
        container.innerHTML = "<p>Roadmap load nahi ho paya. Backend server check karo.</p>";
        console.error(error);
    }
}

async function loadProgress() {
    try {
        const response = await fetch(`${API_BASE}/api/progress?learnerName=${learnerName}`);
        progressData = await response.json();

        const percentage = progressData.percentage || 0;

        document.getElementById("progressText").textContent =
            `${progressData.completedTopics} / ${progressData.totalTopics} topics completed`;

        document.getElementById("progressPercent").textContent =
            `${percentage.toFixed(1)}%`;

        document.getElementById("progressFill").style.width =
            `${percentage}%`;
    } catch (error) {
        console.error(error);
    }
}

async function toggleTopic(topicId) {
    try {
        await fetch(`${API_BASE}/api/progress/toggle`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                learnerName,
                topicId
            })
        });

        await loadProgress();
        await loadRoadmap();
    } catch (error) {
        alert("Progress update nahi hua. Backend check karo.");
        console.error(error);
    }
}

function setupTopicForm() {
    const form = document.getElementById("topicForm");
    const message = document.getElementById("formMessage");

    form.addEventListener("submit", async (event) => {
        event.preventDefault();

        const topicData = {
            phaseId: Number(document.getElementById("phaseId").value),
            topicOrder: Number(document.getElementById("topicOrder").value),
            name: document.getElementById("topicName").value,
            description: document.getElementById("topicDescription").value,
            projectBased: document.getElementById("projectBased").checked
        };

        try {
            const response = await fetch(`${API_BASE}/api/roadmap/topics`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(topicData)
            });

            if (!response.ok) {
                const error = await response.json();
                throw new Error(error.message || "Topic add nahi hua");
            }

            message.textContent = "Topic added successfully.";
            form.reset();

            await loadProgress();
            await loadRoadmap();
        } catch (error) {
            message.textContent = error.message;
            console.error(error);
        }
    });
}
