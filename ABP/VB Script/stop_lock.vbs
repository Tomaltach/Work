Dim objResult

Set objShell = WScript.CreateObject("WScript.Shell")    
i = 0
seconds = 1000
Do While i = 0
  objResult = objShell.sendkeys("{NUMLOCK}{NUMLOCK}")
  Wscript.Sleep (60*seconds)
Loop