const App= () => {
    const [counter, setCounter] = useState(0);
    const handleClick1 = () => {
        setCounter(counter+1);
    }
    const handleClick2 = () => {
        setCounter(counter-1);
    }

    return (
        <div>
            <div>{counter}</div>
            <div>
                <button onClick={handleClick1}>Increment</button>
                <button onClick={handleClick2}>Decrement</button>
                <span>{likes > 0 ? `Like + ${likes}` : ''}</span>
            </div>
        </div>
    )
}
export default App;