impl Solution {
    pub fn count_symmetric_integers(low: i32, high: i32) -> i32 {
        let mut cnt = 0;
        for i in low..=high {
            let s = i.to_string();
            let n = s.len();
            if n % 2 == 0 {
                let mid = n / 2;
                let sum1: i32 = s[..mid].chars().map(|c| c.to_digit(10).unwrap() as i32).sum();
                let sum2: i32 = s[mid..].chars().map(|c| c.to_digit(10).unwrap() as i32).sum();
                if sum1 == sum2 {
                    cnt += 1;
                }
            }
        }
        cnt
    }
}