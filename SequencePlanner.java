
import java.util.Random;

public class SequencePlanner{
    private LaunchSequence solution;
    private SequenceNode head;

    public SequencePlanner(LaunchSequence solution){
        this.solution = solution;
    }
    public SequencePlanner(){
        
        int [] randomSolution = new int[5];
        Random rand = new Random();

        for(int i = 0; i < 5; i++){
            int randomProcedure;
            boolean isUnique = true;
            do {
                randomProcedure = rand.nextInt(1,10);
                for(int el: randomSolution){
                    if(randomProcedure == el){
                        isUnique = false;
                        break;
                    }else{isUnique = true;}
                }          
            } while (!isUnique);

            randomSolution[i] = randomProcedure;

    

        }
        this.solution = new LaunchSequence(randomSolution);
    }

    public boolean checkProposedSequence(LaunchSequence sequence){
        ProposedSequence propSeq = new ProposedSequence(sequence, solution);
        SequenceNode nextProcedure = new SequenceNode(propSeq, this.head);
        this.head = nextProcedure;
        return  propSeq.isCorrect();
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