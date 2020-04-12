public class MaxHeap{
 private int maxSize,size;
 private int[] heap;
 public MaxHeap(int size){
    this.maxSize=size;
    this.size=0;
    heap=new int[this.maxSize+1];
    heap[0]=Integer.MAX_VALUE;
}
private int parent(int pos){
    return pos/2;
}
private int leftChild(int pos){
    return 2*pos;
}

private int rightChild(int pos){
    return 2*pos+1;
}
private boolean isLeaf(int pos){
    if(pos>=(size/2)&&pos<=size)
        return true;
        return false;

}
private void swap(int pos1,int pos2){
    int tmp;
    tmp=heap[pos1];
    heap[pos1]=heap[pos2];
    heap[pos2]=tmp;
}

private void maxHeapify(int pos){
    if(isLeaf(pos))
    return;
    if(heap[pos]<heap[leftChild(pos)]||heap[pos]<heap[rightChild(pos)]){
        if(heap[pos]<heap[leftChild(pos)]){
            swap(pos,leftChild(pos));
            maxHeapify(leftChild(pos));
        }
        else{
            swap(pos,rightChild(pos));
            maxHeapify(rightChild(pos));
        }
    }
}
private void insert(int element){
    heap[++size]=element;
    int current=size;
    while(heap[current]>heap[parent(current)]){
        swap(current,parent(current));
        current=parent(current);
    }
   
}
void sort(){
    for(int i=1;i<=size;i++){
        System.out.print(heap[i]+"  ");
        heap[1]=heap[size--];
        maxHeapify(1);
    }
}
private void print(){
    for(int i=1;i<=size/2;i++){
    System.out.println("parent :" + heap[i] +" left child"+ heap[leftChild(i)] +" right child "+ heap[rightChild(i)]);
    }

}


public static void main(String[] args) {
MaxHeap maxheap=new MaxHeap(15); 
maxheap.insert(5); 
maxheap.insert(3); 
maxheap.insert(17); 
maxheap.insert(10); 
maxheap.insert(84); 
maxheap.insert(19); 
maxheap.insert(6); 
maxheap.insert(22); 
maxheap.insert(9);
maxheap.print();
maxheap.sort();

}


    
}