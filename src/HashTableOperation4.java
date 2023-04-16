import java.util.HashMap;

public class HashTableOperation4 {

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
            int address = 0;

            for(int i = 0; i < key.length(); i++) {
                address += (int) key.charAt(i);
            }

            return address % this.hashTable.length;
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
        // 3-3. 빈번한 충돌을 개선하는 기법
        // > 해쉬 테이블 저장공간을 확대 및 해쉬 함수 재정의
        HashTable hashTable = new HashTable(20);

        hashTable.saveData("DeanKim", "01012345678");
        hashTable.saveData("WonyoungJang", "01033335555");
        hashTable.saveData("DayeonLee", "01044558855");
        hashTable.saveData("Drake", "01011112222");

        String value = hashTable.getData("DeanKim");
        System.out.println(value);      // 01012345678
        
        /* 4. HashMap (해쉬맵) */
        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "포르쉐");
        map1.put(2, "아우디");
        map1.put(3, "벤츠");

        System.out.println(map1.get(1));

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("DeanKim", "01012345678");
        map2.put("WonyoungJang", "01033335555");
        map2.put("DayeonLee", "01044558855");

        System.out.println(map2.get("DeanKim"));
    }
}