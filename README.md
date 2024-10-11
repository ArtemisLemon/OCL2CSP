# OCL2CSP : Choco
**OCL Nodes** modeled as **CSPs** using **Choco-Solver**

## Compilation & Run
```bash
# build
./gradlew build

# run
./gradlew run
```
## CSPs:
- Node
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
 
### Coming Soon
- Arithm (binary)
   - Node
   - Constraint
- Sum    
