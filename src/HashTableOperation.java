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
        /* 1. Hash Table 선언 */
        HashTable hashTable = new HashTable(20);

        hashTable.saveData("DeanKim", "01012345678");
        hashTable.saveData("WonyoungJang", "01033335555");

        String value1 = hashTable.getData("DeanKim");
        System.out.println(value1);
        
        /* 2. 충돌(Collision) 문제점 */
        HashTable hashTable2 = new HashTable(20);

        hashTable2.saveData("DeanKim", "01012345678");
        hashTable2.saveData("WonyoungJang", "01033335555");
        hashTable2.saveData("DayeonLee", "01044558855");
        hashTable2.saveData("Drake", "01011112222");

        String value2 = hashTable2.getData("DeanKim");
        System.out.println(value2);      // 01011112222
        // 현재 구현되어있는 hash function은 key의 첫번째 알파벳을 가져다가 주소 공간을 할당하도록 되어있다.
        // 따라서 가장 마지막에 입력된 key인 Drake의 value가 해당 주소 공간에 저장되어 있는 것
        // > 이러한 충돌 해결을 위해서는 saveData 시 별도의 자료구조를 이용한 로직 개선이 필요하다.

    }
}
