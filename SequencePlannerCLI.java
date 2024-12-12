import java.util.InputMismatchException;
import java.util.Scanner;

class SequencePlannerCLI{
    
    public static void main(String[] args) {
        SequencePlanner sequencePlanner = new SequencePlanner();
        runSimulation(sequencePlanner);
    }
    
    public static void runSimulation(SequencePlanner sequencePlanner){
        
        boolean isCorrectSuggestion = false;
        int numOfAttempts = 0;
        do{
            numOfAttempts++;
            System.out.println("Previous attempts:");
            if(sequencePlanner.getPreviousSuggestions() != null){
                System.out.println(sequencePlanner.getPreviousSuggestions());
            } else {
                System.out.println("No previous attempts");
            }

            Scanner input = new Scanner(System.in);
            
            int[] user_sequence = new int[5];
            boolean isValid = false;
            LaunchSequence suggestion = new LaunchSequence(user_sequence);
            
            while(!isValid){
                System.out.println("Enter new sequence:");
                int i = 0;
                while(i<5){
                    try {
                        user_sequence[i] = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.nextLine();
                        break;
                    }
                    
                    i++;
                }

                isValid = validateSequence(user_sequence);

                if(!isValid){
                    System.out.println("Invalid sequence!");
                }
            }
         
            if(sequencePlanner.checkProposedSequence(suggestion)){
                System.out.println("Sequence verified!");
                System.out.println("The final sequence is:");
                System.out.println(printProcedures(user_sequence));
                System.out.println("You needed " + numOfAttempts + " attempts to find the sequence.");
                isCorrectSuggestion = true;
            }
            
        }while(!isCorrectSuggestion);
    }

    public static boolean validateSequence(int[] sequence){
        for (int num : sequence) {
            if (num < 1 || num > 9) {
                return false;
            }
        }

        for (int i = 0; i < sequence.length; i++) {
            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[i] == sequence[j]) {
                    return false;
                }
            }
        }

        return true;

    }

    public static String printProcedures(int[] correctSequence){
        String proceduresString = "";
        String[] procedures = new String[]{
            "System Check",
            "Fuel Loading",
            "Navigation Setup",
            "Communication Test",
            "Engine Ignition",
            "Weather Verification",
            "Crew Boarding",
            "Safety Override",
            "Launch Pad Clear"            
        };
    
        for(int el: correctSequence){
            proceduresString+=procedures[el-1] + "\n";
        }

        return proceduresString.trim();
    }
}