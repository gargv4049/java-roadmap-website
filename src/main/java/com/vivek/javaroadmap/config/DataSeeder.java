package com.vivek.javaroadmap.config;

import com.vivek.javaroadmap.model.RoadmapPhase;
import com.vivek.javaroadmap.model.RoadmapTopic;
import com.vivek.javaroadmap.repository.RoadmapPhaseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final RoadmapPhaseRepository phaseRepository;

    public DataSeeder(RoadmapPhaseRepository phaseRepository) {
        this.phaseRepository = phaseRepository;
    }

    @Override
    public void run(String... args) {
        if (phaseRepository.count() > 0) {
            return;
        }

        RoadmapPhase phase1 = new RoadmapPhase(
                1,
                "Java Fundamentals",
                "Beginner",
                "2-3 Weeks",
                "Java syntax, variables, operators, loops, methods, arrays and strings strong karna.",
                "Is phase me Java ki basic grammar aur small programs practice karne hain."
        );
        phase1.addTopic(new RoadmapTopic(1, "JDK Setup and First Program", "JDK install karo, IDE setup karo, Hello World run karo.", false));
        phase1.addTopic(new RoadmapTopic(2, "Variables and Data Types", "int, double, char, boolean, String use karna seekho.", false));
        phase1.addTopic(new RoadmapTopic(3, "Operators and Conditions", "Arithmetic, relational, logical operators, if-else, switch.", false));
        phase1.addTopic(new RoadmapTopic(4, "Loops", "for, while, do-while aur pattern programs.", false));
        phase1.addTopic(new RoadmapTopic(5, "Methods", "Reusable functions, parameters, return type.", false));
        phase1.addTopic(new RoadmapTopic(6, "Arrays and Strings", "Array traversal, searching, reverse, palindrome, string methods.", true));

        RoadmapPhase phase2 = new RoadmapPhase(
                2,
                "Object-Oriented Programming",
                "Core Java",
                "3-4 Weeks",
                "Class, object, constructor, inheritance, polymorphism, abstraction and interface master karna.",
                "Ye Java ka heart hai. Isko strong karna placement aur backend dono ke liye important hai."
        );
        phase2.addTopic(new RoadmapTopic(1, "Class and Object", "Class blueprint hoti hai, object uska real instance hota hai.", false));
        phase2.addTopic(new RoadmapTopic(2, "Constructor and this Keyword", "Object initialize karna aur current object ko refer karna.", false));
        phase2.addTopic(new RoadmapTopic(3, "Encapsulation", "Private variables + getter/setter se data secure karna.", true));
        phase2.addTopic(new RoadmapTopic(4, "Inheritance and super", "Parent class se properties lena aur parent constructor/method call karna.", false));
        phase2.addTopic(new RoadmapTopic(5, "Polymorphism", "Overloading and overriding using one name many forms.", true));
        phase2.addTopic(new RoadmapTopic(6, "Abstraction and Interface", "Implementation hide karna aur rules define karna.", true));

        RoadmapPhase phase3 = new RoadmapPhase(
                3,
                "Collections, Exceptions and Files",
                "Intermediate",
                "3-4 Weeks",
                "Real Java programs ke liye Collections Framework, exception handling aur file handling seekhna.",
                "Collections DSA aur backend me daily use hoti hain."
        );
        phase3.addTopic(new RoadmapTopic(1, "ArrayList and LinkedList", "Dynamic list operations and when to use which.", false));
        phase3.addTopic(new RoadmapTopic(2, "Stack, Queue and PriorityQueue", "LIFO, FIFO and priority-based data structures.", false));
        phase3.addTopic(new RoadmapTopic(3, "HashSet and TreeSet", "Duplicate remove karna, sorted unique values.", false));
        phase3.addTopic(new RoadmapTopic(4, "HashMap", "Key-value pair, frequency counting, lookup.", true));
        phase3.addTopic(new RoadmapTopic(5, "Exception Handling", "try, catch, finally, throw, throws.", false));
        phase3.addTopic(new RoadmapTopic(6, "File Handling", "File create, read, write, append, delete.", true));

        RoadmapPhase phase4 = new RoadmapPhase(
                4,
                "DSA in Java",
                "Placement Level",
                "3-5 Months",
                "Arrays, strings, recursion, linked list, stack, queue, trees, graph and DP practice karna.",
                "DSA placement ke liye sabse important phase hai."
        );
        phase4.addTopic(new RoadmapTopic(1, "Time and Space Complexity", "Big O notation and performance analysis.", false));
        phase4.addTopic(new RoadmapTopic(2, "Arrays and Strings Problems", "Two pointer, sliding window, hashing basics.", false));
        phase4.addTopic(new RoadmapTopic(3, "Recursion and Backtracking", "Base case, recursive call, choices.", false));
        phase4.addTopic(new RoadmapTopic(4, "Linked List", "Reverse, middle, cycle detection.", false));
        phase4.addTopic(new RoadmapTopic(5, "Stack and Queue", "Valid parentheses, next greater element, BFS basics.", false));
        phase4.addTopic(new RoadmapTopic(6, "Trees, Graphs and DP", "Traversal, DFS, BFS, shortest path, DP basics.", true));

        RoadmapPhase phase5 = new RoadmapPhase(
                5,
                "Database and Backend",
                "Advanced",
                "2-3 Months",
                "JDBC, MySQL, Spring Boot, REST API, JPA and deployment basics seekhna.",
                "Is phase me Java ko real backend development me use karna hai."
        );
        phase5.addTopic(new RoadmapTopic(1, "MySQL Basics", "Tables, CRUD, joins, constraints.", false));
        phase5.addTopic(new RoadmapTopic(2, "JDBC", "Java se database connect karna.", true));
        phase5.addTopic(new RoadmapTopic(3, "Spring Boot Basics", "Spring Initializr, Maven, controllers, services.", false));
        phase5.addTopic(new RoadmapTopic(4, "REST APIs", "GET, POST, PUT, DELETE endpoints.", true));
        phase5.addTopic(new RoadmapTopic(5, "Spring Data JPA", "Repository pattern and database operations.", true));
        phase5.addTopic(new RoadmapTopic(6, "Security, Testing and Deployment", "JWT basics, JUnit, Swagger, deploy.", true));

        phaseRepository.save(phase1);
        phaseRepository.save(phase2);
        phaseRepository.save(phase3);
        phaseRepository.save(phase4);
        phaseRepository.save(phase5);
    }
}
