public class HashTableOperation {

    public static class HashTable {
        public Slot[] hashTable;

        public HashTable(Integer size) {
            this.hashTable = new Slot[size];
        }

        public class Slot {
            String value;
            Slot(String value) {
                this.value = value;
            }
        }

        public Integer hashFunc(String key) {
            // hashtable의 길이로 나눈 나머지를 주소로 리턴한다면,
            // hashTable의 길이 - 1 만큼의 주소를 만들어낼 수 있으므로,
            // 모든 hashTable의 주소의 공간을 가리킬 수 있다.
            return (int) key.charAt(0) % this.hashTable.length;
        }

        public boolean saveData(String key, String value) {
            Integer address = this.hashFunc(key);

            if(this.hashTable[address] != null) {
                this.hashTable[address].value = value;
            } else {
                this.hashTable[address] = new Slot(value);
            }

            return true;
        }

        public String getData(String key) {
            Integer address = this.hashFunc(key);

            if(this.hashTable[address] != null) {
                return this.hashTable[address].value;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        // Hash Table 선언
        HashTable hashTable = new HashTable(20);
        hashTable.saveData("DeanKim", "01012345678");
        hashTable.saveData("WonyoungJang", "01033335555");

        String returnValue = hashTable.getData("DeanKim");

        System.out.println(returnValue);

    }
}
