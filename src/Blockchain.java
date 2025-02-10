import java.util.ArrayList;

/**
 * Implements a simple blockchain data structure.
 * This implementation includes basic blockchain operations and validation mechanisms.
 */
public class Blockchain{
    /** ArrayList to store the chain of blocks */
    public ArrayList<Block> blockchain;

    /**
     * Constructs a new blockchain and initializes it with a genesis block.
     */
    public Blockchain(){
        blockchain = new ArrayList<>();
        blockchain.add(createGenesisBlock());
    }
    //creating the first block
    /**
     * Creates the first block (genesis block) of the blockchain.
     * 
     * @return Block The genesis block
     */
    private Block createGenesisBlock(){
        return new Block(0,"Genesis Block","0");
    }
    //to get the latest block
    /**
     * Retrieves the most recent block in the blockchain.
     * 
     * @return Block The latest block in the chain
     */
    private Block getLatestBloke(){
        return blockchain.get(blockchain.size()-1);
    }
    //to add new block
    /**
     * Adds a new block to the blockchain with the specified data.
     * 
     * @param data The data to be stored in the new block
     */
    void addBlock(String data){
        Block lastBlock = getLatestBloke();
        Block newBlock= new Block(lastBlock.index+1,data,lastBlock.hash);
        blockchain.add(newBlock);
    }

    //for the purpose of demonesetration
    /**
     * Removes a block at the specified index.
     * Note: This method is for demonstration purposes only.
     * Real blockchains do not support block deletion as it breaks immutability.
     * 
     * @param index The index of the block to be deleted
     */
    public void DeleteBlock(int index){
        if(index<0||index>=blockchain.size()){
            System.out.println("Index out of bounds");
        }
        else{
            blockchain.remove(index);
        }
    }
    //Validation
    /**
     * Validates the integrity of the entire blockchain.
     * Checks both the hash of each block and the links between blocks.
     * 
     * @return boolean True if the blockchain is valid, false otherwise
     */
    public boolean iscahinvalid(){
        for(int i = 1; i<blockchain.size(); i++){
            Block CurrentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i-1);
            if (!CurrentBlock.hash.equals(CurrentBlock.CalculateHash())){
                System.out.println("Block"+CurrentBlock.index+"does  not match ");
                return false;
            }
            if (!CurrentBlock.previousHash.equals(previousBlock.hash)){
                System.out.println("Previous Block"+CurrentBlock.index+" Is not properly matched ");
                return false;
            }
        }
        return true;
    }
    /**
     * Displays all blocks in the blockchain with their properties.
     * Outputs index, hash, previous hash, and timestamp for each block.
     */
    public void DisplayBlockchain(){
        for(Block block : blockchain){
            System.out.println("Block " + block.index + " | Hash: " + block.hash + " | PrevHash: " + block.previousHash+"|Time;"+block.timestamp);

        }
    }

}
