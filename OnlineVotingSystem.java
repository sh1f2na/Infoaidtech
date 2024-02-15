import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class VotingSystem {
    private Map<String, Integer> candidates;

    public VotingSystem() {
        this.candidates = new HashMap<>();
    }

    public void addCandidate(String candidateName) {
        candidates.put(candidateName, 0);
    }

    public void displayCandidates() {
        System.out.println("Candidates:");
        for (String candidate : candidates.keySet()) {
            System.out.println(candidate);
        }
    }

    public void vote(String candidateName) {
        if (candidates.containsKey(candidateName)) {
            int currentVotes = candidates.get(candidateName);
            candidates.put(candidateName, currentVotes + 1);
            System.out.println("Vote cast for " + candidateName);
        } else {
            System.out.println("Invalid candidate. Please choose a valid candidate.");
        }
    }

    public void displayResults() {
        System.out.println("Voting Results:");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}

public class OnlineVotingSystem {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Candidate");
            System.out.println("2. Display Candidates");
            System.out.println("3. Vote");
            System.out.println("4. Display Results");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter candidate name: ");
                    String candidateName = scanner.nextLine();
                    votingSystem.addCandidate(candidateName);
                    break;
                case 2:
                    votingSystem.displayCandidates();
                    break;
                case 3:
                    System.out.print("Enter the candidate you want to vote for: ");
                    String voteFor = scanner.nextLine();
                    votingSystem.vote(voteFor);
                    break;
                case 4:
                    votingSystem.displayResults();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
