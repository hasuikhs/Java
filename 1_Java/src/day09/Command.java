package day09;

@FunctionalInterface
public interface Command {
	void exec();
	default public void process() { // 인터페이스 디폴트 메소드
		System.out.println("process()");
	}
}

class DeleteCommand implements Command{
	public void exec() {
		System.out.println("DeleteCommand 수행");
	}
}

class CreateCommand implements Command{
	public void exec() {
		System.out.println("CreateCommand 수행");
	}
}

class UpdateCommand implements Command{
	public void exec() {
		System.out.println("UpdateCommand 수행");
	}
}

class ListCommand implements Command{
	public void exec() {
		System.out.println("ListCommand 수행");
	}
}
