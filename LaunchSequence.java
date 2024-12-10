public class LaunchSequence{
    private int[] sequence;

    public LaunchSequence(int[] sequence){
        this.sequence = sequence;
    }

    public int getProcedure(int i){
        return sequence[i];
    }

    @Override
    public String toString(){
        String stringSequence = "";
        for(int procedure: sequence){
            stringSequence+=procedure + " ";
        }
        return stringSequence.trim();
    }
}
