public class ProposedSequence{
    private LaunchSequence suggestion;
    private LaunchSequence solution;

    public ProposedSequence(LaunchSequence suggestion, LaunchSequence solution){
        this.suggestion = suggestion;
        this.solution = solution;
    }

    public LaunchSequence getSequence(){
        return suggestion;
    }

    public int getNumCorrect(){
        return 0;
    }
    public int getNumWrongPosition(){
        return 0;
    }

    @Override
    public String toString(){
        return suggestion.toString() + " (Correct " + getNumCorrect() + ", Wrong position " + getNumWrongPosition() + ")";
    }
}