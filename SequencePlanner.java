

public class SequencePlanner{
    LaunchSequence solution;
    private SequenceNode head;
    public SequencePlanner(LaunchSequence solution){
        this.solution = solution;
        this.head = null;
    }

    public boolean checkProposedSequence(LaunchSequence sequence){
        ProposedSequence propSeq = new ProposedSequence(sequence, solution);
        SequenceNode nextProcedure = new SequenceNode(propSeq, head);
        head = nextProcedure;
        return false;
    }

    public String getPreviousSuggestions(){
        return head.getNext().getPayload();
    }

    public LaunchSequence getSolution(){
        return solution;
    }

}