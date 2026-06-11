impl Solution {
    const MOD: i64 = 1_000_000_007;

    fn dfs(adj: &Vec<Vec<usize>>, curr: usize, parent: usize) -> i32 {
        let mut depth = 0;

        for &node in &adj[curr] {
            if node == parent {
                continue;
            }

            depth = depth.max(Self::dfs(adj, node, curr) + 1);
        }

        depth
    }

    pub fn assign_edge_weights(edges: Vec<Vec<i32>>) -> i32 {
        let n = edges.len() + 1;
        let mut adj = vec![Vec::new(); n + 1];

        for edge in edges {
            let u = edge[0] as usize;
            let v = edge[1] as usize;

            adj[u].push(v);
            adj[v].push(u);
        }

        let depth = Self::dfs(&adj, 1, 0);

        let mut ans: i64 = 1;
        let mut d = depth;

        while {
            d -= 1;
            d > 0
        } {
            ans = (ans * 2) % Self::MOD;
        }

        ans as i32
    }
}