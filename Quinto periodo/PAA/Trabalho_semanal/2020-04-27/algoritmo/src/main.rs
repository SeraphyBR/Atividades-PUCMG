
fn sum(vec: &[i32], left: usize, right: usize) -> i32 {

    if left != right {
        let m = (left + right) / 2;
        sum(vec, left, m) + sum(vec, m + 1, right)
    }
    else {
        vec[left]
    }
}

fn main() {
    let vetor: Vec<i32> = vec![1,2,3,4,5,6,7,8,9,10];
    let soma = sum(&vetor, 0, vetor.len() - 1);
    println!("{}", soma);
}
