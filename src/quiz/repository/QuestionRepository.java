package quiz.repository;
import quiz.model.Question;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    public List<Question> loadQuestions() {
        List<Question> list = new ArrayList<>();

        // --- Core Java Basics ---
        list.add(new Question("Which component is used to compile, debug and execute java programs?", "JVM", "JDK", "JIT", "JRE", 'B'));
        list.add(new Question("What is the extension of java code files?", ".txt", ".pdf", ".sql", ".java", 'D'));
        list.add(new Question("What is the size of int variable?", "8 bit", "16 bit", "32 bit", "64 bit", 'C'));
        list.add(new Question("What is the default value of a local variable?", "null", "0", "Depends on data type", "No default value", 'D'));
        list.add(new Question("Which of these cannot be used for a variable name in Java?", "identifier & keyword", "identifier", "keyword", "none of the mentioned", 'C'));
        list.add(new Question("Which environment variable is used to set the java path?", "MAVEN_PATH", "JavaPATH", "JAVA", "JAVA_HOME", 'D'));
        list.add(new Question("What is meant by the classes and objects that depend on each other?", "Tight Coupling", "Cohesion", "Loose Coupling", "None of the above", 'A'));
        list.add(new Question("Which of the following is not an OOPS concept in Java?", "Polymorphism", "Inheritance", "Compilation", "Encapsulation", 'C'));
        list.add(new Question("What is the size of float and double in java?", "32 and 64", "32 and 32", "64 and 64", "64 and 32", 'A'));
        list.add(new Question("Automatic type conversion is possible in which of the possible cases?", "Byte to int", "Int to long", "Long to int", "Short to int", 'B'));

        // --- Object-Oriented Programming (OOP) ---
        list.add(new Question("Which concept allows you to reuse the written code?", "Encapsulation", "Abstraction", "Inheritance", "Polymorphism", 'C'));
        list.add(new Question("Method overriding is an example of?", "Static Binding", "Dynamic Binding", "Both", "None", 'B'));
        list.add(new Question("Which keyword is used to prevent inheritance?", "static", "constant", "final", "abstract", 'C'));
        list.add(new Question("What is true about constructors?", "Can return a value", "Can be static", "Name must match class name", "Can be abstract", 'C'));
        list.add(new Question("Which class is the superclass of all classes in Java?", "Main", "Object", "Super", "System", 'B'));
        list.add(new Question("Which keyword is used to access features of a package?", "import", "package", "extends", "export", 'A'));
        list.add(new Question("What happens if a class does not implement all methods of an interface?", "It compiles successfully", "It must be declared abstract", "Throws runtime exception", "None of above", 'B'));
        list.add(new Question("Multiple inheritance is supported in Java through?", "Classes", "Interfaces", "Both", "None", 'B'));
        list.add(new Question("What is the output of Math.floor(3.6)?", "3", "3.0", "4", "4.0", 'B'));
        list.add(new Question("Which block executes regardless of exception occurrence?", "try", "catch", "finally", "throw", 'C'));

        // --- Strings & Arrays ---
        list.add(new Question("Which of these classes are the direct subclasses of the Throwable class?", "RuntimeException and Error", "Exception and VirtualMachineError", "Error and Exception", "IOException and VirtualMachineError", 'C'));
        list.add(new Question("String in Java is a?", "class", "object", "variable", "character array", 'A'));
        list.add(new Question("Which memory is used by String Pool?", "Heap memory", "Stack memory", "PermGen", "None", 'A'));
        list.add(new Question("Which method is used to find the length of a string?", "length()", "length", "size()", "getSize()", 'A'));
        list.add(new Question("Which method is used to find the length of an array?", "length()", "length", "size()", "getSize()", 'B'));
        list.add(new Question("Is StringBuilder thread-safe?", "Yes", "No", "Depends on JVM", "Sometimes", 'B'));
        list.add(new Question("Which class provides thread-safe string manipulation?", "String", "StringBuilder", "StringBuffer", "StringThread", 'C'));
        list.add(new Question("Arrays in java are-", "Object references", "objects", "Primitive data type", "None", 'B'));
        list.add(new Question("When is the object created with new keyword?", "At run time", "At compile time", "Depends on the code", "None", 'A'));
        list.add(new Question("Identify the incorrect signature of method.", "public int get(int a)", "int get(int a)", "private double get()", "public String get(String a, b)", 'D'));

        // --- Exception Handling ---
        list.add(new Question("What is the base class of all exceptions?", "java.lang.Exception", "java.lang.Throwable", "java.lang.Error", "java.lang.RuntimeException", 'B'));
        list.add(new Question("Which exception is thrown when divide by zero occurs?", "NullPointerException", "ArithmeticException", "NumberFormatException", "None", 'B'));
        list.add(new Question("Can we have a try block without a catch block?", "Yes, if finally block is present", "No", "Yes, always", "Compilation Error", 'A'));
        list.add(new Question("Which keyword is used to explicitly throw an exception?", "try", "catch", "throw", "throws", 'C'));
        list.add(new Question("Which exception is thrown if an array is accessed out of bounds?", "ArrayIndexOutOfBoundsException", "IndexOutOfBoundsException", "Both A and B", "None", 'A'));
        list.add(new Question("Difference between throw and throws?", "throw is for methods, throws is for blocks", "throw is for explicit exception, throws for method signature", "Both are same", "None", 'B'));
        list.add(new Question("Are Error and Exception the same?", "Yes", "No", "Error is subclass of Exception", "Exception is subclass of Error", 'B'));
        list.add(new Question("What happens if an exception is not caught?", "Program compiles but terminates abnormally", "Program ignores it", "Program continues executing", "Compilation error", 'A'));
        list.add(new Question("Checked exceptions are checked at?", "Runtime", "Compile time", "Both", "None", 'B'));
        list.add(new Question("Unchecked exceptions are subclasses of?", "Exception", "Error", "RuntimeException", "Throwable", 'C'));

        // --- Collections Framework ---
        list.add(new Question("Which interface does java.util.Hashtable implement?", "Java.util.Map", "Java.util.List", "Java.util.HashTable", "Java.util.Collection", 'A'));
        list.add(new Question("Which of the following does not allow duplicate elements?", "List", "Set", "Map", "All of the above", 'B'));
        list.add(new Question("Which collection maintains insertion order?", "HashSet", "TreeSet", "LinkedHashSet", "HashMap", 'C'));
        list.add(new Question("Which collection sorts its elements by default?", "HashSet", "LinkedHashSet", "TreeSet", "ArrayList", 'C'));
        list.add(new Question("Difference between ArrayList and Vector?", "ArrayList is synchronized", "Vector is synchronized", "Both are synchronized", "Neither is synchronized", 'B'));
        list.add(new Question("What is the default capacity of an ArrayList?", "0", "10", "16", "32", 'B'));
        list.add(new Question("Which map allows one null key and multiple null values?", "TreeMap", "Hashtable", "HashMap", "ConcurrentHashMap", 'C'));
        list.add(new Question("Which map does not allow null keys or values?", "HashMap", "LinkedHashMap", "Hashtable", "WeakHashMap", 'C'));
        list.add(new Question("Which interface is the root of the collection framework hierarchy?", "Collection", "Root", "Iterable", "List", 'A'));
        list.add(new Question("How do you iterate over a Map in Java?", "Iterator", "Map.Entry", "KeySet", "All of the above", 'D'));

        // --- Multithreading ---
        list.add(new Question("How can we create a thread in Java?", "By extending Thread class", "By implementing Runnable interface", "Both A and B", "By extending Runnable class", 'C'));
        list.add(new Question("Which method is called internally by Thread.start()?", "run()", "execute()", "main()", "init()", 'A'));
        list.add(new Question("Can we call the run() method directly?", "Yes, but it won't create a new thread", "No, compilation error", "Yes, creates a new thread", "Throws exception", 'A'));
        list.add(new Question("Which keyword is used to make a method thread-safe?", "volatile", "synchronized", "static", "final", 'B'));
        list.add(new Question("What is the state of a thread after calling start()?", "New", "Runnable", "Running", "Dead", 'B'));
        list.add(new Question("Which method pauses a thread for a specific duration?", "wait()", "stop()", "sleep()", "pause()", 'C'));
        list.add(new Question("Difference between wait() and sleep()?", "wait releases the lock", "sleep releases the lock", "both release the lock", "neither releases the lock", 'A'));
        list.add(new Question("What is a daemon thread in Java?", "A high priority thread", "A low priority background thread", "A dead thread", "Main thread", 'B'));
        list.add(new Question("Which thread is created first when a Java program starts?", "System Thread", "Daemon Thread", "Main Thread", "Child Thread", 'C'));
        list.add(new Question("What happens if you call start() twice on the same thread?", "Runs twice", "Throws IllegalThreadStateException", "Ignored", "Compilation error", 'B'));

        // --- Java 8 Features ---
        list.add(new Question("Which symbol is used for lambda expressions?", "->", "=>", "::", "~>", 'A'));
        list.add(new Question("What is a functional interface?", "Interface with many methods", "Interface with exactly one abstract method", "Interface with no methods", "None", 'B'));
        list.add(new Question("Which annotation enforces a functional interface?", "@FunctionalInterface", "@SingleMethod", "@Lambda", "@Interface", 'A'));
        list.add(new Question("What is the purpose of the Stream API?", "File I/O", "Network connections", "Functional-style operations on collections", "Database access", 'C'));
        list.add(new Question("Which method in Stream is used to transform data?", "filter()", "map()", "reduce()", "collect()", 'B'));
        list.add(new Question("Which feature prevents NullPointerException in Java 8?", "Optional", "Lambda", "Stream", "Method Reference", 'A'));
        list.add(new Question("Which symbol is used for Method References?", ".", "->", "::", ":", 'C'));
        list.add(new Question("Can interfaces have method bodies in Java 8?", "No", "Yes, using default and static keywords", "Yes, using final", "Yes, using abstract", 'B'));
        list.add(new Question("Which package contains the new Date and Time API?", "java.util.date", "java.time", "java.sql.date", "java.calendar", 'B'));
        list.add(new Question("What does the forEach method do in Java 8?", "Iterates over elements", "Filters elements", "Sorts elements", "Removes elements", 'A'));

        // --- JDBC (Advanced Java) ---
        list.add(new Question("What does JDBC stand for?", "Java Database Connectivity", "Java Data Base Concept", "Java Developer Basic Connection", "Java Database Concept", 'A'));
        list.add(new Question("Which package contains the JDBC API?", "java.sql", "javax.sql", "Both A and B", "java.db", 'C'));
        list.add(new Question("Which method is used to register a JDBC driver?", "Class.forName()", "DriverManager.register()", "Both A and B", "Connection.start()", 'C'));
        list.add(new Question("Which interface is used to execute parameterized SQL queries?", "Statement", "PreparedStatement", "CallableStatement", "ResultSet", 'B'));
        list.add(new Question("Which interface executes stored procedures?", "Statement", "PreparedStatement", "CallableStatement", "ResultSet", 'C'));
        list.add(new Question("What does ResultSet represent?", "A database connection", "A SQL statement", "A table of data generated by a query", "Database metadata", 'C'));
        list.add(new Question("Which method returns the number of rows updated in JDBC?", "executeQuery()", "executeUpdate()", "execute()", "getRow()", 'B'));
        list.add(new Question("What is the purpose of Connection.commit()?", "Saves changes to the database", "Closes connection", "Rolls back changes", "Opens connection", 'A'));
        list.add(new Question("What is a JDBC Driver?", "An interface", "A software component enabling java apps to interact with DB", "A database system", "A JVM component", 'B'));
        list.add(new Question("How do you disable auto-commit in JDBC?", "connection.setAutoCommit(false)", "connection.commit(false)", "statement.setAutoCommit(false)", "None", 'A'));

        // --- Servlets & JSP (Advanced Java) ---
        list.add(new Question("What is a Servlet?", "A java program that runs on a web server", "A client-side script", "A database trigger", "A GUI component", 'A'));
        list.add(new Question("Which method is called first in a Servlet life cycle?", "doGet()", "service()", "init()", "destroy()", 'C'));
        list.add(new Question("How many times is the init() method called in a Servlet's life?", "Once per request", "Once per session", "Once per initialization", "Every minute", 'C'));
        list.add(new Question("Which method is used to process a GET request?", "doPost()", "processGet()", "doGet()", "serviceGet()", 'C'));
        list.add(new Question("What is the difference between sendRedirect and forward?", "sendRedirect changes URL, forward doesn't", "forward changes URL, sendRedirect doesn't", "Both are same", "None", 'A'));
        list.add(new Question("What is JSP?", "Java Server Pages", "Java Standard Pages", "Java Server Programming", "Java Servlet Pages", 'A'));
        list.add(new Question("What gets generated when a JSP page is compiled?", "A Servlet", "An HTML file", "A JavaScript file", "An Applet", 'A'));
        list.add(new Question("Which implicit object is used to store data across the whole application?", "request", "session", "application", "pageContext", 'C'));
        list.add(new Question("What is the syntax for a JSP expression?", "<% ... %>", "<%= ... %>", "<%@ ... %>", "<%! ... %>", 'B'));
        list.add(new Question("Which tag is used to define methods and variables in JSP?", "Scriptlet <% %>", "Expression <%= %>", "Declaration <%! %>", "Directive <%@ %>", 'C'));

        // --- Advanced Java Concepts (Hibernate, Spring, JPA, Design Patterns) ---
        list.add(new Question("What is Hibernate?", "A web server", "An ORM framework", "A GUI toolkit", "A database", 'B'));
        list.add(new Question("What does ORM stand for?", "Object Relational Mapping", "Object Runtime Memory", "Object Relational Model", "Overridden Relational Model", 'A'));
        list.add(new Question("Which file is used for Hibernate configuration?", "hibernate.cfg.xml", "spring.xml", "web.xml", "pom.xml", 'A'));
        list.add(new Question("In Spring, what does IoC stand for?", "Inversion of Control", "Integration of Components", "Input Output Context", "Inheritance of Classes", 'A'));
        list.add(new Question("What is Dependency Injection?", "Hardcoding dependencies", "Passing dependencies by the framework", "A database injection attack", "None of the above", 'B'));
        list.add(new Question("Which design pattern ensures only one instance of a class exists?", "Factory", "Observer", "Singleton", "Decorator", 'C'));
        list.add(new Question("Which pattern is used to create objects without specifying the exact class?", "Singleton", "Factory", "Strategy", "Adapter", 'B'));
        list.add(new Question("What does MVC stand for?", "Model View Controller", "Module Variable Class", "Main View Component", "Model View Component", 'A'));
        list.add(new Question("In MVC, which component handles the business logic?", "View", "Controller", "Model", "None", 'C'));
        list.add(new Question("What is the purpose of Maven?", "Database management", "Build and dependency management", "Web hosting", "Code compilation only", 'B'));

        return list;
    }
}