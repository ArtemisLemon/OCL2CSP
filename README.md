# OCL2CSP : Choco
AIMT: OCL 2 CSP 4 ATLc (CP++)

**OCL Nodes** modeled as **CSPs** using **Choco-Solver**

## Compile & Run
```bash
# build
./gradlew build

# run
./gradlew run
```
## CSPs:
The CSPs are *composable* with compilation in mind.
Generally, a `::nodeCSP` will provide `vars()` to pass information *up*.

### UML CSPs:
CSP of the model instance conforming to UML.
Calling methods like `setIsUnique` and `setContainment` can't be undone, as they `.post()` Choco constraints.

- AdjListTable::PropArrayTable : Associations as references <-> Pointer Arrays
   - AdjList::IntVar[] : reference <-> Pointer Array
       - setIsUnique()
   - adjlist(objectID)
   - setContainment()

### OCL CSPs:
CSP of the model instance conforming to OCL

- navCSP : Navigation <-> Property Arrays
  - navCSP(AdjList src, PropArrayTable prop)
- Includes : Application of inclusion constraints (not reified, IF includes THEN ... not supported by this)
  - includes : (int[] src, intvar body)
  - includesAll : (int[], intvar[] body)
  - includesAll : (int[], adjlist)
 
### Coming Next
- PropArray::IntVar[]
- Arithm (binary)
   - Node
   - Constraint
- Sum

## Coming After
- AdjSet <- Set Variables, Choco's Union as navCSP
- XOCL2CSP
- ATLc Update
