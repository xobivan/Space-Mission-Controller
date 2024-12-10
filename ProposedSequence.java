public class ProposedSequence{
    private LaunchSequence suggestion;
    private LaunchSequence solution;

    public ProposedSequence(LaunchSequence suggestion, LaunchSequence solution){
        this.suggestion = suggestion;
        this.solution = solution;
    }

    public boolean isCorrect(){
        return suggestion.toString().equals(solution.toString());
        
    }

    public LaunchSequence getSequence(){
        return suggestion;
    }

    public int getNumCorrect(){
        int numCorrect = 0;
        for(int i = 0; i < 5; i++){
            if(suggestion.getProcedure(i) == solution.getProcedure(i)){
                numCorrect++;
            }
        }
        return numCorrect;
    }
    public int getNumWrongPosition(){
        int numWrong = 0;
        String solutionString = solution.toString().replace(" ", "");
        String suggestionString = suggestion.toString().replace(" ", "");

        for(int i = 0; i < solutionString.length(); i++){
            if(solutionString.charAt(i) != suggestionString.charAt(i)){
                if(solutionString.contains(String.valueOf(suggestionString.charAt(i)))){
                    numWrong++;
                }
            }
        }

        return numWrong;
    }


    @Override
    public String toString(){
        return suggestion.toString() + " (Correct " + getNumCorrect() + ", Wrong position " + getNumWrongPosition() + ")";
    }
}