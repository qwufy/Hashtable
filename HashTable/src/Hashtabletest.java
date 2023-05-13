public class Hashtabletest {
    private int id;
    private String name;

    public  Hashtabletest(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public  boolean equals(Object o){
        if (o == this){
            return true;
        }
        if(!(o instanceof Hashtabletest)){
            return false;
        }
        Hashtabletest other = (Hashtabletest) o;
        return id == other.id && name.equals(other.name);
    }
}
