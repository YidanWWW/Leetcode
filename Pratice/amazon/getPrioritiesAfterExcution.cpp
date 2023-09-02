//https://leetcode.com/discuss/interview-question/3838416/Amazon-OA/

vector<int> solution(const vector<int> &v) {
    priority_queue<int> q;
    unordered_map<int, set<int>> have;
    const int n = v.size();
    for (int i = 0; i < n; ++i) {
        have[v[i]].insert(i);
        if (have[v[i]].size() == 2) {
            q.push(v[i]);
        }
    }
    while (!q.empty()) {
        const int p = q.top();
        have[p].erase(have[p].begin());
        const int p2 = p >> 1;
        have[p2].insert(*have[p].begin());
        have[p].erase(have[p].begin());
        if (have[p].size() < 2) {
            q.pop();   
        }
        if (p2 && have[p2].size() > 1) {
            q.push(p2);
        }
    }
    vector<int> r(n, -1);
    for (const auto& p : have) {
        for (int x : p.second) {
            r[x] = p.first;
        }
    }
    int m = 0;
    for (int i = 0; i < n; ++i) {
        if (r[i] >= 0) {
            r[m++] = r[i];
        }
    }
    r.resize(m);
    return r;
}

void print(const vector<int> &r) {
    for (int x : r) {
        cout << x << " ";
    }
    cout << endl;
}


int main() {
    print(solution({6, 6, 6, 1, 2, 2}));
    print(solution({4, 4, 2, 1}));
}