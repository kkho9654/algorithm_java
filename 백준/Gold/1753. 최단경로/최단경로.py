import sys,heapq
input = sys.stdin.readline
INF = sys.maxsize
V,E = map(int, input().split(' '))
K = int(input())
hq = []
dp = [INF for _ in range(V+1)]
graph = [[] for _ in range(V+1)]
for i in range(E):
    u,v,w = map(int, input().split(' '))
    graph[u].append((v,w))

dp[K] = 0
heapq.heappush(hq, (0,K))
while hq:
    weight , current = heapq.heappop(hq)
    # 가중치 업데이트
    if dp[current] < weight:
        continue

    for next_node, new_weight in graph[current]:
        updated_weight = weight + new_weight
        if dp[next_node] > updated_weight:
            dp[next_node] = updated_weight
            heapq.heappush(hq,(updated_weight, next_node))

for i in range(1, V+1):
    if dp[i] == INF:
        print('INF')
    else:
        print(dp[i])
# 1. 방문하지 않은 곳 중 가장 비용이 작은 곳 선택
# 2. 선택된 노드를 거쳐가는 모든 경우들과 dp를 비교하여서 가중치 업데이트
# 3. 만약 업데이트가 된다면 최소힙에  업데이트된 노드와 업데이트된 비용을 삽입...
# 1번으로 다시 돌아가는데 이 대 최소힙에 삽입된것으로 선택한다.... 
