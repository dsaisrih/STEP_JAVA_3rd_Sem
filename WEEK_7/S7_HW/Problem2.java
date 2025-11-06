class Course {
    String title, instructor, enrollmentDate;

    public Course(String title, String instructor, String enrollmentDate) {
        this.title = title;
        this.instructor = instructor;
        this.enrollmentDate = enrollmentDate;
    }

    public void showProgress() {
        System.out.println("Course progress for: " + title);
    }
}

class VideoCourse extends Course {
    int completionPercentage, watchTime;

    public VideoCourse(String title, String instructor, String enrollmentDate, int completion, int watchTime) {
        super(title, instructor, enrollmentDate);
        this.completionPercentage = completion;
        this.watchTime = watchTime;
    }

    @Override
    public void showProgress() {
        System.out.println("🎥 Video Course: " + title + " | Completion: " + completionPercentage + "% | Watch Time: " + watchTime + " hrs");
    }
}

class InteractiveCourse extends Course {
    int quizScore, projectsCompleted;

    public InteractiveCourse(String title, String instructor, String enrollmentDate, int score, int projects) {
        super(title, instructor, enrollmentDate);
        this.quizScore = score;
        this.projectsCompleted = projects;
    }

    @Override
    public void showProgress() {
        System.out.println("🖱️ Interactive Course: " + title + " | Quiz Score: " + quizScore + " | Projects Completed: " + projectsCompleted);
    }
}

class ReadingCourse extends Course {
    int pagesRead;
    boolean notesTaken;

    public ReadingCourse(String title, String instructor, String enrollmentDate, int pagesRead, boolean notesTaken) {
        super(title, instructor, enrollmentDate);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }

    @Override
    public void showProgress() {
        System.out.println("📖 Reading Course: " + title + " | Pages Read: " + pagesRead + " | Notes Taken: " + notesTaken);
    }
}

class CertificationCourse extends Course {
    int examAttempts;
    boolean certified;

    public CertificationCourse(String title, String instructor, String enrollmentDate, int attempts, boolean certified) {
        super(title, instructor, enrollmentDate);
        this.examAttempts = attempts;
        this.certified = certified;
    }

    @Override
    public void showProgress() {
        System.out.println("🎓 Certification Course: " + title + " | Exam Attempts: " + examAttempts + " | Certified: " + certified);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Basics", "Alice", "01-09-2025", 70, 15),
            new InteractiveCourse("Python Projects", "Bob", "05-09-2025", 85, 3),
            new ReadingCourse("DSA Guide", "Charlie", "10-09-2025", 120, true),
            new CertificationCourse("AWS Certification", "Diana", "15-09-2025", 2, false)
        };

        for (Course c : courses) {
            c.showProgress();
        }
    }
}
