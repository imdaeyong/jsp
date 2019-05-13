package kr.co.java2;

class Args {

		int x;
		
		public void add(int x) {
			this.x = x+50;//의미없음. 이x가 아니라 위의 x에 대입해야함 this를 붙여줘야함 붙여주면 150/190/190 아니면 100/140/140
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
