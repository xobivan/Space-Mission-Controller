import java.util.Scanner;
class SequencePlannerCLI{
    
    public static void main(String[] args) {
        SequencePlanner sequencePlanner = new SequencePlanner();
        runSimulation(sequencePlanner);
    }
    
    public static void runSimulation(SequencePlanner sequencePlanner){
        
        boolean isCorrectSuggestion = false;
        do{
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
                    user_sequence[i] = input.nextInt();
                    i++;
                }

                isValid = validateSequence(user_sequence);

                if(!isValid){
                    System.out.println("Invalid sequence!");
                }
            }
         
            if(sequencePlanner.checkProposedSequence(suggestion)){
                System.out.println("Sequence verified!");
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
}