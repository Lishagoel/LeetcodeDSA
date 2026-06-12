use std::collections::HashMap;

impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {

        let list1_map: HashMap<_, _> = list1.into_iter().enumerate().map(|(i, s)| (s, i)).collect();
        let mut minx = usize::MAX;
        let mut result = vec![];

        for (i, s) in list2.iter().enumerate() {
            if let Some(&j) = list1_map.get(s) {
                if i + j < minx {
                    minx = i + j;
                    result = vec![s.clone()];
                } else if (i + j == minx) {
                    result.push(s.clone());
                }
            }
        }

        result
    }
}