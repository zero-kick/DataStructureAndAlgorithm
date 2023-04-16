public class HashTableOperation2 {

    public static class HashTable {
        public Slot[] hashTable;

        public HashTable(Integer size) {
            this.hashTable = new Slot[size];
        }

        public class Slot {
            String key;
            String value;
            Slot next;
            Slot(String key, String value) {
                this.key = key;
                this.value = value;
                this.next = null;
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
                Slot findSlot = this.hashTable[address];
                Slot prevSlot = this.hashTable[address];

                while(findSlot != null) {
                    if(findSlot.key == key) {
                        findSlot.value = value;
                        return true;
                    } else {
                        prevSlot = findSlot;
                        findSlot = findSlot.next;
                    }
                }

                prevSlot.next = new Slot(key, value);
            } else {
                this.hashTable[address] = new Slot(key, value);
            }

            return true;
        }

        public String getData(String key) {
            Integer address = this.hashFunc(key);

            if(this.hashTable[address] != null) {
                Slot findSlot = this.hashTable[address];
                while(findSlot != null) {
                    if(findSlot.key == key) {
                        return findSlot.value;
                    } else {
                        findSlot = findSlot.next;
                    }
                }
                return null;
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        /* 3. 충돌 해결을 위한 기법 */
        // 3-1. Chaining 기법
        HashTable hashTable = new HashTable(20);

        hashTable.saveData("DeanKim", "01012345678");
        hashTable.saveData("WonyoungJang", "01033335555");
        hashTable.saveData("DayeonLee", "01044558855");
        hashTable.saveData("Drake", "01011112222");

        String value2 = hashTable.getData("DeanKim");
        System.out.println(value2);      // 01012345678
    }
}
