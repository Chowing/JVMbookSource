package geym.zbase.ch11.agent.attach;

import java.io.IOException;
import java.util.List;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

/**
 * Add tools.jar
 * @author geym
 *
 */
public class AttachToolMain {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        List<VirtualMachineDescriptor> list = VirtualMachine.list();  
        for (VirtualMachineDescriptor vmd : list)  
        {  
            if(vmd.displayName().endsWith("RunLoopAccountMain")){  
                VirtualMachine virtualmachine = VirtualMachine.attach(vmd.id());  
                virtualmachine.loadAgent("D:\\ja.jar", "argument for agent");
                System.out.println("ok");
                virtualmachine.detach();
            }
        } 
    }
}
