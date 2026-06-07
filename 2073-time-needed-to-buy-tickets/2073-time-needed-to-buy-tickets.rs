impl Solution {
    pub fn time_required_to_buy(tickets: Vec<i32>, k: i32) -> i32 {
        tickets.iter().enumerate().fold(0, |s, (i, &v)| s + std::cmp::min(tickets[k as usize] - i32::from(i as i32>k), v))
    }
}