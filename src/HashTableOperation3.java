public class HashTableOperation3 {

    public static class HashTable {
        public Slot[] hashTable;

        public HashTable(Integer size) {
            this.hashTable = new Slot[size];
        }

        public class Slot {
            String key;
            String value;
            Slot(String key, String value) {
                this.key = key;
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
                if(this.hashTable[address].key == key) {
                    this.hashTable[address].value = value;
                    return true;
                } else {
                    Integer currAddress = address + 1;
                    while(this.hashTable[currAddress] != null) {
                        if(this.hashTable[currAddress].key == key) {
                            this.hashTable[currAddress].value = value;
                            return true;
                        } else {
                            currAddress++;
                            if(currAddress >= this.hashTable.length) {
                                return false;
                            }
                        }
                    }
                    this.hashTable[currAddress] = new Slot(key, value);
                    return true;
                }
            } else {
                this.hashTable[address] = new Slot(key, value);
            }
            return true;
        }

        public String getData(String key) {
            Integer address = this.hashFunc(key);

            if(this.hashTable[address] != null) {
                if(this.hashTable[address].key == key) {
                    return this.hashTable[address].value;
                } else {
                    Integer currAddress = address + 1;
                    while(this.hashTable[currAddress] != null) {
                        if(this.hashTable[currAddress].key == key) {
                            return this.hashTable[currAddress].value;
                        } else {
                            currAddress++;
                            if(currAddress >= this.hashTable.length) {
                                return null;
                            }
                        }
                    }
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    public static void main(String[] args) {
        /* 3. 충돌 해결을 위한 기법 */
        // 3-2. Linear Probing 기법
        HashTable hashTable = new HashTable(20);

        hashTable.saveData("DeanKim", "01012345678");
        hashTable.saveData("WonyoungJang", "01033335555");
        hashTable.saveData("DayeonLee", "01044558855");
        hashTable.saveData("Drake", "01011112222");

        String value = hashTable.getData("DeanKim");
        System.out.println(value);      // 01012345678
        
        // 3-3. 빈번한 충돌을 개선하는 기법
        // > 해쉬 테이블 저장공간을 확대 및 해쉬 함수 재정의
    }
}