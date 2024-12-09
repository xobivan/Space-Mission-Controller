public class SequencePlanner{
    private LaunchSequence solution;
    private SequenceNode head;
    public SequencePlanner(LaunchSequence solution){
        this.solution = solution;
        this.head = null;
    }

    public boolean checkProposedSequence(LaunchSequence sequence){
        ProposedSequence propSeq = new ProposedSequence(sequence, solution);
        SequenceNode nextProcedure = new SequenceNode(propSeq, this.head);
        this.head = nextProcedure;
        return false;
    }

    public String getPreviousSuggestions(){
        if (this.head == null) {
            return null;
        }
        return this.head.toString();
    }

    public LaunchSequence getSolution(){
        return solution;
    }

}