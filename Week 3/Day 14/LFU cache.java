lass LFUCache {
     private int capacity;
    private Map<Integer, Integer> keyToValueMap;
    private Map<Integer, Integer> keyToFrequencyMap;
    private Map<Integer, List<Integer>> frequencyToKeysMap;
    private int minFrequency;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValueMap = new HashMap<>();
        keyToFrequencyMap = new HashMap<>();
        frequencyToKeysMap = new HashMap<>();
        minFrequency = 0;
    }
    
    public int get(int key) {
         if (!keyToValueMap.containsKey(key)) {
            return -1;
    }
        updateFrequency(key);
        return keyToValueMap.get(key);
    }
    
    public void put(int key, int value) {
     if (capacity == 0) {
            return;
        }

        if (keyToValueMap.containsKey(key)) {
            keyToValueMap.put(key, value);
            updateFrequency(key);
        } else {
            if (keyToValueMap.size() >= capacity) {
                evictLeastFrequent();
            }

            keyToValueMap.put(key, value);
            keyToFrequencyMap.put(key, 1);
            frequencyToKeysMap.computeIfAbsent(1, k -> new ArrayList<>()).add(key);
            minFrequency = 1;
        }
    }
      private void updateFrequency(int key) {
        int freq = keyToFrequencyMap.get(key);
        keyToFrequencyMap.put(key, freq + 1);

        List<Integer> keysWithSameFreq = frequencyToKeysMap.get(freq);
        keysWithSameFreq.remove(Integer.valueOf(key));
        if (keysWithSameFreq.isEmpty()) {
            frequencyToKeysMap.remove(freq);
        }

        frequencyToKeysMap.computeIfAbsent(freq + 1, k -> new ArrayList<>()).add(key);

        if (freq == minFrequency && !frequencyToKeysMap.containsKey(freq)) {
            minFrequency++;
        }
    }

    private void evictLeastFrequent() {
        List<Integer> keysToEvict = frequencyToKeysMap.get(minFrequency);
        int keyToRemove = keysToEvict.remove(0);
        if (keysToEvict.isEmpty()) {
            frequencyToKeysMap.remove(minFrequency);
        }

        keyToValueMap.remove(keyToRemove);
        keyToFrequencyMap.remove(keyToRemove);
    }
}
