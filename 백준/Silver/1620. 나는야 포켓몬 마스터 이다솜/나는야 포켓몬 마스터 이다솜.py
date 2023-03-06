import sys

input = sys.stdin.readline

N, M = map(int, input().rstrip().split())
dic = dict()

for i in range(1, N+1):
    st = input().rstrip()
    dic[str(i)] = st
    dic[st] = str(i)

for _ in range(M):
    x = input().rstrip()
    print(dic[x])

"""
26 5
Bulbasaur
Ivysaur
Venusaur
Charmander
Charmeleon
Charizard
Squirtle
Wartortle
Blastoise
Caterpie
Metapod
Butterfree
Weedle
Kakuna
Beedrill
Pidgey
Pidgeotto
Pidgeot
Rattata
Raticate
Spearow
Fearow
Ekans
Arbok
Pikachu
Raichu
25
Raichu
3
Pidgey
Kakuna

"""
