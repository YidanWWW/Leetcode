import React, {
    useState
} from React;

const login = () => {
    const [username, setUsername] = useState[''];
    const [password, setPassword] = useState[''];
    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }
    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }
    const handleSubmit = async (event) => {
        event.preventDefault();
        //add some login logic here, eg: send them to server for authentacation
        
        const requestBody = {username:username, password:password}

        try{
            const response = await fetch('/api/login', {
                method: 'POST',
                headers: {
                    'Content-Type':'aplication/json'
                },
                body: JSON.stringify(requestBody)
            })

            if(response.ok) {
                console.log('Success')
            }else {
                console.log('Failure')
            }
        }catch (error) {
            console.error('Error', error);
        }
        
        console.log('username', username);
        console.log('password', password);
    }
    return ( 
        <div>
            <h2>Login</h2>
            <form onSubmit = {handleSubmit}>
                <div classname = "form-group">
                    <lable>username</lable>
                    <input
                    type = "text"
                    id = "username"
                    value = {username}
                    onChange = {handleUsernameChange}
                    />
                </div>
                <div>
                    <lable>password</lable>
                    <input
                    type = "password"
                    value = {password}
                    id = "password"
                    onChange = {handlePasswordChange}
                    />
                </div>
                <buttom type="submit">Login</buttom>
            </form>
        </div>
    )
}
export default login;