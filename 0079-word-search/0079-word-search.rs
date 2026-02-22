use std::collections::{ HashSet, HashMap };
impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        let mut word = word.chars().collect::<Vec<char>>();

        if let Some(should_reverse) = Solution::optimize_search_space(&board, &word) {
            if should_reverse { word.reverse(); }
        } else {
            return false; 
        }

        let mut current: HashSet<(usize, usize)> = HashSet::new();
        let (rows, cols) = ( board.len(), board[0].len() );
        let directions = vec![(1, 0), (-1, 0), (0, 1), (0, -1)];
        for i in 0..rows {
            for j in 0..cols {
                if board[i][j] != word[0] { continue; }
                if Solution::backtrack(1, &word, &board, i as i32, j as i32, &mut current, &directions) { return true; }
            }
        }

        false
    }

    fn backtrack(
        i: usize,
        word: &Vec<char>,
        board: &Vec<Vec<char>>,
        row: i32,
        col: i32,
        current: &mut HashSet<(usize, usize)>,
        directions: &Vec<(i32, i32)>,
    ) -> bool {
        if i == word.len() { return true; }

        current.insert((row as usize, col as usize));
        
        for dir in directions.iter() {
            let r = row + dir.0;
            let c = col + dir.1;

            if !Solution::within_limits(r, c, board.len(), board[0].len()) || current.contains(&(r as usize, c as usize)) { continue; }
            if board[r as usize][c as usize] != word[i] { continue; }
            if Solution::backtrack(i+1, word, board, r, c, current, directions) {
                return true;
            }

        }

        current.remove(&(row as usize, col as usize));
        false

    }

    fn within_limits(r: i32, c: i32, rows: usize, cols: usize) -> bool {
        r.min(c) >= 0 && (r as usize) < rows && (c as usize) < cols 
    }

    /// If frequency of the first character is more than the last, then reverse it to
    /// reduce the starting search space. Also, keep count of each unique character of word
    /// if board doesn't have those many characters in the first space, return None to
    /// suggest the main code to return false early
    fn optimize_search_space(board: &Vec<Vec<char>>, word: &Vec<char>) -> Option<bool> {
        let rows = board.len();
        let cols = board[0].len();

        // If the total number of elements in board is less than the required word length
        if rows * cols < word.len() { return None; }

        let mut word_freq: HashMap<char, i32> = HashMap::new();
        for ch in word {
            word_freq.entry(*ch).and_modify(|x| *x += 1).or_insert(1);
        }

        let mut first_char_count = 0;
        let mut last_char_count = 0;

        for i in 0..rows {
            for j in 0..cols {
                word_freq.entry(board[i][j]).and_modify(|x| *x -= 1);
                if board[i][j] == word[0] { first_char_count += 1; }
                else if board[i][j] == word[word.len()-1] { last_char_count += 1; }
            }
        }

        if word_freq.values().any(|x| *x > 0) { return None; }
        if word[0] == word[word.len()-1] { return Some(false); }

        Some(first_char_count > last_char_count)
    }
}