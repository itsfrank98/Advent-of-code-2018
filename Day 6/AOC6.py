# -*- coding: utf-8 -*-
"""
Created on Thu Dec  6 17:07:52 2018

@author: franc
"""

from numpy import *

def manhattan(i,j):
    return abs(i[0]-j[0])+abs(i[1]-j[1])

def extract_vet():
    coord={}
    for line in open(r"C:\Users\franc\Desktop\A.txt"):
        x,y=[int(s.strip()) for s in line.split(',')]
        coord[(x,y)]=0
        
    return coord

def find_maxx_maxy(coordinate):
    maxx=0
    maxy=0
    coord=[]
    coord=list(coordinate.keys())
    for i in range(0, len(coord)):
        if coord[i][0]>maxx:
            maxx=coord[i][0]
        if coord[i][1]>maxy:
            maxy=coord[i][1]
    
    return (maxx,maxy)


"""The following takes in input a first couple of values, 
which are the coordinate of which I want to find the nearest. The second parameter is the
list of the coordinates given in input. I'll calculate the manhattan between each element
of this list and the coordinate I gave in input, then take the smallest one
"""   
def calcola_piu_vicino(coord_to_check,coordinate):   
    dim=len(coordinate)
    dist=0
    min=1000
    coord=list(coordinate.keys())
    for k in range(0,dim):
        dist=manhattan(coord_to_check, coord[k])
        if dist<min:
            min=dist
            count=1
            nearest_cell=coord[k]
        elif dist==min:
            count+=1
    if count>1:
        return (-1,-1)
    else:
        return nearest_cell
                    
def find_max(coord,n,m):
    max =0
    key_max=0
    for i in range(0,n):
        for j in range(0,m):
            coordinata=calcola_piu_vicino((i,j),coord)
            if coordinata[0]!=-1:
                if i==0 or i==n or j==0 or j==m:
                    coord[coordinata]=-200000   #in this way I ignore the values on the bounds of the 'matrix'
                else:
                    coord[coordinata]+=1

    for key, val in coord.items():
        if coord[key]>max:
            max=coord[key]
            key_max=key
    
    return (key_max,max)
    
#max_key is the key of the cell which has the largest area which isn't infinite
def max_area(coord,n,m):
    cont=0
    for i in range(0,n):
        for j in range(0,m):
            sum=0
            for key, val in coord.items():
                sum+= manhattan(key, (i,j))
            if sum<10000:
                cont+=1
    return cont
       
     
def main():
    a=extract_vet()
    (x,y) = find_maxx_maxy(a)
    #task 1
    t=find_max(a,x,y)
    maxi=t[1]
    print('Task 1:')
    print(maxi)
    print('\n')
    #task 2
    print('Task 2:')
    print(a,x,y))
