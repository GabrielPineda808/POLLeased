export interface OptionVote{
    pollOption: string;
    voteCount: number;
}
export interface Poll {
    id: number;
    question: string;
    options: OptionVote[];
}
