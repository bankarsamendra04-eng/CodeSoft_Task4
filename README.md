# Professional Quiz Application with Timer (Java Swing)

A robust, enterprise-grade Desktop Quiz application built purely using Java Swing and AWT. Structured strictly using the Model-View-Controller (MVC) architecture, SOLID principles, and clean Object-Oriented design.

## Features
* **Modern UI**: Custom-painted gradients, rounded buttons, and hover animations without using JavaFX.
* **Smart Timer**: Integrated 30-second countdown timer per question with auto-submit logic.
* **State Management**: Ability to Skip, go Next, or go Previous without losing selected options.
* **Automated Scoring**: Automatically calculates percentages, correct/wrong/skipped counts, and assigns grades (A+, B, C, etc.).
* **Detailed Review System**: Scrollable review screen showing your answers vs correct answers with visual markers.

## Tech Stack
* Language: Java SE (JDK 8+)
* GUI: Java Swing & AWT
* Architecture: MVC

## Author
Generated for Professional Portfolio & College Submissions.

# Project Structure
```
QuizApplication/
├── src/
│   └── quiz/
│       ├── main/
│       │   └── Main.java
│       ├── model/
│       │   ├── Question.java
│       │   ├── Student.java
│       │   └── Result.java
│       ├── view/
│       │   ├── SplashScreen.java
│       │   ├── LoginFrame.java
│       │   ├── DashboardFrame.java
│       │   ├── QuizFrame.java
│       │   ├── ResultFrame.java
│       │   └── ReviewFrame.java
│       ├── controller/
│       │   └── AppController.java
│       ├── service/
│       │   ├── QuizService.java
│       │   └── TimerService.java
│       ├── repository/
│       │   └── QuestionRepository.java
│       ├── util/
│       │   ├── Constants.java
│       │   ├── Theme.java
│       │   └── Validator.java
│       └── components/
│           ├── RoundedButton.java
│           └── GradientPanel.java
└── README.md
```


