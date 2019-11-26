const getCurrentPageUserId = () => {
    let currentUserId = window.location.href;

    let tempArr = currentUserId.split("/");

    return tempArr[tempArr.length - 1]
};


$('#searchUserMessage').keyup(function () {
    let userSearch = $('#searchUserMessage').val();
    console.log("fire 🔥🔥🔥🔥🔥🔥🔥");
    $('#messageUserResults').html('');
    // If search input is not empty
    if (userSearch !== "" ){

        fetch('/search?username=' + userSearch)
            .then(response => response.json())

            .then(users => users.map((user) => {
                if (userSearch === ""){
                    $('#messageUserResults').hide();

                }else {
                    // let url = '/message/' + user.id ;
                    let url = '/message/' + user.id + '/send' ;
                    console.log(url);
                    $('#messageUserResults').append('<form class=" searchResultItem list-group-item list-group-item-action link-class" action="'+url+'" method="post">' +
                        '<a class=" text-decoration-none messageLi"' + ' type="submit"' + ' href=' + url + '  >' + user.id + " " + user.username + " " + user.city + ", " + user.state +'</a></form>');
                    console.log(user.username);
                }
            }))

    }

});// end of keyup eventlistner


// $('#searchBtn').click(function () {
//     let userSearch = $('#search').val();
//     if (userSearch !== ""){
//         fetch('/search?username=' + userSearch)
//             .then(response => response.json())
//             .then(users => users.map((user) => {
//                 if (userSearch === ""){
//                     $('#result').hide();
//                 } else {
//                     $('#result').html('<a href="/send/${user.id}/message"><li class="list-group-item link-class"><p class="messageLi">' + user.id + " " + user.username + " " + user.city + ", " + user.state +'</p></th></a>')
//
//                 }
//             }))
//     }
// });