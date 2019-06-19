
const auth = {
    accessToken: ''
}

const signIn = (username, password) => fetch(`/users/signin?username=${username}&password=${password}`, {method: 'POST'})
    .then((data) => data.text())
    .then(console.log);

export {
    auth,
    signIn
}