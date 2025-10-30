import java.util.*;

public class EmailAnalyzer {

    static class EmailInfo {
        String email, username, domain, domainName, extension;
        boolean isValid;
    }

    // b. Validate email format
    public static boolean isValidEmail(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        int dot = email.indexOf('.', at + 1);
        return at > 0 && lastAt == at && dot > at + 1 && dot < email.length() - 1;
    }

    // c. Extract components
    public static EmailInfo extractComponents(String email) {
        EmailInfo info = new EmailInfo();
        info.email = email;
        info.isValid = isValidEmail(email);

        if (info.isValid) {
            int at = email.indexOf('@');
            int dot = email.indexOf('.', at);
            info.username = email.substring(0, at);
            info.domain = email.substring(at + 1);
            info.domainName = email.substring(at + 1, dot);
            info.extension = email.substring(dot + 1);
        } else {
            info.username = info.domain = info.domainName = info.extension = "-";
        }

        return info;
    }

    // d. Analyze statistics
    public static void analyzeStats(List<EmailInfo> emails) {
        int validCount = 0, totalLength = 0;
        Map<String, Integer> domainFreq = new HashMap<>();

        for (EmailInfo e : emails) {
            if (e.isValid) {
                validCount++;
                totalLength += e.username.length();
                domainFreq.put(e.domain, domainFreq.getOrDefault(e.domain, 0) + 1);
            }
        }

        String commonDomain = "-";
        int maxFreq = 0;
        for (String dom : domainFreq.keySet()) {
            if (domainFreq.get(dom) > maxFreq) {
                maxFreq = domainFreq.get(dom);
                commonDomain = dom;
            }
        }

        double avgLength = validCount > 0 ? (double) totalLength / validCount : 0;

        System.out.println("\n📊 Email Statistics:");
        System.out.println("Total Emails: " + emails.size());
        System.out.println("Valid Emails: " + validCount);
        System.out.println("Invalid Emails: " + (emails.size() - validCount));
        System.out.println("Most Common Domain: " + commonDomain);
        System.out.printf("Average Username Length: %.2f\n", avgLength);
    }

    // e. Display results
    public static void displayResults(List<EmailInfo> emails) {
        System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s\n",
                "Email", "Username", "Domain", "Domain Name", "Extension", "Valid");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (EmailInfo e : emails) {
            System.out.printf("%-30s %-15s %-20s %-15s %-10s %-10s\n",
                    e.email, e.username, e.domain, e.domainName, e.extension, e.isValid ? "Yes" : "No");
        }
    }

    // f. Main function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<EmailInfo> emails = new ArrayList<>();

        System.out.println("Enter email addresses (empty line to end):");
        while (true) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;
            emails.add(extractComponents(line));
        }

        displayResults(emails);
        analyzeStats(emails);
    }
}
