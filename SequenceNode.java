class SequenceNode{
    private ProposedSequence payload;
    private SequenceNode next;

    public SequenceNode(ProposedSequence payload, SequenceNode next){
        this.payload = payload;
        this.next = next;
    }

    public String getValue() {return payload.toString();}
    public SequenceNode getNext(){return next;}


    @Override
    public String toString(){
        SequenceNode pointer = this;
        String history = "";

        if (next != null) {
            while(pointer!=null){
                history+=pointer.getValue()+ "\n";
                pointer = pointer.getNext();
            }
            return history;
        }else{
            return payload.toString();
        }

        
    }
}