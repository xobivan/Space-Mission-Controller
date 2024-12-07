class SequenceNode{
    private ProposedSequence payload;
    private SequenceNode next;

    public SequenceNode(ProposedSequence payload, SequenceNode next){
        this.payload = payload;
        this.next = next;
    }

    public String getPayload() {return payload.toString();}
    public SequenceNode getNext(){return next;}
}
