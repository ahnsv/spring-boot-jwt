const auth = {
  accessToken: ''
}

function signIn(username, password) {
  return fetch(`http://localhost:8080/users/signin?username=${username}&password=${password}`,
    {method: 'POST'})
    .then(res => {
      if (res.ok) {
        return res.text()
      } else {
        switch (res.status) {
        case 422:
          throw new Error(`잘못된 군번 또는 비밀번호를 입력하셨습니다.`)
        case 400:
          throw new Error(`잘못된 요청입니다.`)
        default:
          console.log(`unhandled error number`)
        }
        throw new Error()
      }
    })
    .then(token => {
      console.log(`result token is added to auth`)
      auth.accessToken = token
      return JSON.stringify(auth)
    })
  // .catch(err => {
  //     alert(err);
  // })
}

export {
  signIn
}