import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * Represents a block in the blockchain.
 * Each block contains index, timestamp, data, and hash information.
 */
public class Block {
    /** The position of the block in the blockchain */
    public int index;
    
    /** Unix timestamp of when the block was created */
    public long timestamp;
    
    /** The data stored in the block */
    public String data;
    
    /** Hash of the previous block in the chain */
    public String previousHash;
    
    /** Hash of the current block */
    public String hash;

    /**
     * Constructs a new Block with the specified parameters.
     * 
     * @param index The position of the block in the chain
     * @param data The data to be stored in the block
     * @param previousHash The hash of the previous block
     */
    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.timestamp = Instant.now().toEpochMilli();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = CalculateHash();
    }

    /**
     * Calculates the SHA-256 hash of the block using its properties.
     * 
     * @return String representation of the block's hash
     */
    public String CalculateHash() {
        String input = index + "," + timestamp + "," + data + "," + previousHash;
        return applySha256(input);
    }

    public String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
