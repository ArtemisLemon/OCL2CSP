# OCL2CSP : Choco
AIMT: OCL 2 CSP 4 ATLc

**OCL Nodes** modeled as **CSPs** using **Choco-Solver**

## Compilation & Run
```bash
# build
./gradlew build

# run
./gradlew run
```
## CSPs:
- ::Node
   - vars()
### UML CSPs:
CSP of the model instance conforming to UML

- AdjListTable::PropArrayTable : Associations as references <-> Pointer Arrays
   - AdjList : reference <-> Pointer Array
       - setIsUnique()
   - adjlist(objectID)
   - setContainment()

### OCL CSPs:
CSP of the model instance conforming to OCL

- navCSP : Navigation <-> Property Arrays
  - navCSP(AdjList src, PropArrayTable prop)
- Includes : Application of inclusion constraints (not reified, IF includes THEN ... not supported by this)
  - includes : intvar
  - includesAll : intvar[]
  - includesAll : adjlist
 
### Coming Next
- PropArray
- Arithm (binary)
   - Node
   - Constraint
- Sum    

## Coming After
- AdjSet <- Set Variables, Choco's Union as navCSP
- EMF&OCL2CSP
- ATLc Update
