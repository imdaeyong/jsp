package kr.co.java2;

class Args {

		int x;
		
		public void add(int x) {
			this.x = x+50;//�ǹ̾���. ��x�� �ƴ϶� ���� x�� �����ؾ��� this�� �ٿ������ �ٿ��ָ� 150/190/190 �ƴϸ� 100/140/140
		}
		
		public void add(int[] arr) {
			arr[0]++;
		}
		
		public void add(Args arg) {
			arg.x = arg.x + 40;
		}
		
		/*public  addNew(Args arg) {
			arg=new Args();
		
		}*/
		public Args addNew(Args arg) {
			arg=new Args();
			return arg;
		}
		
		
}
