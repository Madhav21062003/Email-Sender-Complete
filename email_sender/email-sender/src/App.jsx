import "./App.css";
import EmailSender from "./components/EmailSender";
import { Toaster } from "react-hot-toast";
function App() {
  return (
    <>
      <EmailSender />
      <Toaster />
    </>
  );
}

export default App;
