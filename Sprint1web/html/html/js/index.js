
const people = [
    {name: 'josep'},
    {name: 'alberto'},
    {name: 'andrei'},
    {name: 'sofian'}
];

const list = document.getElementById('list');

function setList(group){
clearList();
    for(const person of group){
        const item = document.createElement('li');
        item.classList.add('list-group-item');
        const text = document.createTextNode(person.name);
        item.appendChild(text);
        list.appendChild(item);
    }
    if(group.length === 0){
        setNoResults();
    }
}
function clearList(){
    while(list.firstChild){
        list.removeChild(list.firstChild);
    }
}
function setNoResults(){
    const item =document.createElement('li');
    item.classList.add('list-group-item');
    const text =document.createTextNode('No Results Found');
    item.appendChild(text);
    list.appendChild(item);

}
function  getRelevancy(value, searchTerm){
    if(value=== searchTerm){
        return 2;
    }
    else if(value.startsWith(searchTerm)) {
        return 1;
    }
    else if(value.includes(searchTerm)){
        return 0;
    }
}
const searchInput =document.getElementById('search');

searchInput.addEventListener('input',(event ) =>  {
    let value = event.target.value;
    if (value && value.trim().length > 0){
        value = value.trim().toLowerCase(); //canviar a minuscules per a la busqueda
        setList(people.filter(person =>{ //La funció en arrow te 1 estat i retorna un valor, i t'ahorra el return i els claudators.
            return person.name.includes(value);
        }).sort((personA, personB) => {
            return getRelevancy(personB.name, value) - getRelevancy(personA.name, value);
            }));
    } else{
        clearList();
    }
});




