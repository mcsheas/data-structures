public class SaraContainer
{
    private int[] variableData;
    private int currPosition; 
    
    /*public SaraContainer(int[] userArray, int userCurrPosition, int userLen){
        variableData = userArray;
        len = userLen;
    }*/
    
    public SaraContainer(int size){
        variableData = new int[size]; 
        currPosition = 0;
    }

    public int getElem(int position){
        /*int elem = 0;
         for (int i = 0; i<position; i++){
             elem = variableData[i];
         }
         return elem;*/
        if (position<0|| position>currPosition){
            throw new IndexOutOfBoundsException("Invalid Position" +position);
        }
        return variableData[position];
        }
    
    public void add(int num){
        int size = variableData.length;
        if (currPosition>=size){
            int newSize = size *=2;
            int[] newArray = new int[newSize]; 
            for (int i=0; i<currPosition; i++){
                newArray[i]=variableData[i];
            }
            variableData = newArray;
        }
        variableData[currPosition] = num;  
        currPosition++;
        }

    
    public void clear(int size){
        variableData = new int[size];
        currPosition = 0;
    }
    
    public boolean isEmpty(){
        return currPosition==0;
    }
    
    public int size(){
        return currPosition;
    }
    
    public void clear(){
        variableData = new int[variableData.length];
        currPosition = 0;
    }
    
    
    /**
     * return the index of a value looking for
     */
    public int indexOf(int value){
        for(int i=0;i<currPosition;i++){
            if (variableData[i]==value){
                return i;
            }
        }
        return -1; //what to return when value is not in the array, will be covered with exception handling in the future 
    }
    
    public void remove(int position){
        int[] newArray = new int[currPosition-1];
        
        for(int i=0; i<=position;i++){
            if (position==i){
                newArray[i]=variableData[i+1];
                for(int j =position+2; j<currPosition;i++){
                    position++;
                    newArray[position]=variableData[j];
                    
                }
                variableData = newArray;
                currPosition--;
                return;
            }else{
                newArray[i]=variableData[i];
            }
        }
    }
    
    public void addFirst(int value){
        int[] newArray = new int[currPosition+1];
        newArray[0]= value;
        for (int i = 0; i<currPosition; i++){
            newArray[i+1]=variableData[i];
        }
        variableData = newArray;
        currPosition++;
    }
    
    public void removesFirst(){
        if (currPosition == 0){
            System.out.println("Array is empty, cannot remove the last element.");
            return;
        }
        int[] newArray = new int[currPosition-1];
        for (int i = 0; i<currPosition-1;i++){
            newArray[i]=variableData[i+1];
        }
        variableData = newArray;
        currPosition--;
    }
    
    public void removesLast(){
        if (currPosition == 0){
            System.out.println("Array is empty, cannot remove the last element.");
            return;
        }
        int[] newArray = new int[currPosition-1];
        for (int i=0; i<currPosition-1;i++){
            newArray[i]=variableData[i];
        }
        variableData = newArray;
        currPosition--;
        
    }
    
    public void add(int position, int value){
        try{
            if (position <0 || position>currPosition){
                throw new IndexOutOfBoundsException("Invalid Position: " +position);
            }
            int size = variableData.length;
            int newSize = size *=2;
            int[] newArray = new int[newSize];
            if (currPosition>=size){
                for (int i=0; i<currPosition; i++){
                    newArray[i]=variableData[i];
                }
                variableData = newArray;
                
            }
        
            for(int i=currPosition; i>position;i--){
                newArray[i]=variableData[i-1];
            }
        
            newArray[position]=value; 
        }catch (IndexOutOfBoundsException e){
        System.out.println("You have no value in that element, you should just add a value without a position.");
        }
    }
    
    public void replace (int position, int value){
        if (position < 0 || position>=currPosition){
            throw new IndexOutOfBoundsException("Invalid Position" + position);
        }
        variableData[position]=value;
    }
    
    @Override 
    public String toString(){
        String arr = "[";
        /*if (currPosition == 0){
            arr += " ]";
            return arr;
        }*/
        for (int i = 0;i<variableData.length;i++){
            String value = variableData[i] +  "";
            if (i==variableData.length-1){
                arr = arr + value + "]";
                return arr;
            }
            arr = arr + value +", ";        
        }
        return arr;
    }
    
    
}
